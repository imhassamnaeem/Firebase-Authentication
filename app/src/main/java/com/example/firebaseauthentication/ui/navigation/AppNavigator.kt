package com.example.firebaseauthentication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.firebaseauthentication.ui.presentation.home.HomeEvent
import com.example.firebaseauthentication.ui.presentation.home.HomeScreen
import com.example.firebaseauthentication.ui.presentation.home.HomeViewModel
import com.example.firebaseauthentication.ui.presentation.login.LoginEvent
import com.example.firebaseauthentication.ui.presentation.login.LoginScreen
import com.example.firebaseauthentication.ui.presentation.login.LoginViewModel
import com.example.firebaseauthentication.ui.presentation.signup.SignUpEvent
import com.example.firebaseauthentication.ui.presentation.signup.SignUpScreen
import com.example.firebaseauthentication.ui.presentation.signup.SignupViewModel
import com.example.firebaseauthentication.ui.presentation.splash.SplashEvent
import com.example.firebaseauthentication.ui.presentation.splash.SplashScreen
import com.example.firebaseauthentication.ui.presentation.splash.SplashViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigator() {
    val backStack = rememberNavBackStack(Screens.Splash)
    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },
        entryProvider = entryProvider {
            entry<Screens.Splash>
            {
                val viewModel: SplashViewModel = koinViewModel()
                LaunchedEffect(Unit)
                {
                    viewModel.event.collect { event ->
                        when(event){
                            SplashEvent.NavigateToLogin->{
                                backStack.clear()
                                backStack.add(Screens.Login)
                            }
                            SplashEvent.NavigateToHome->{
                                backStack.clear()
                                backStack.add(Screens.Home)
                            }
                        }
                    }
                }
                SplashScreen()
            }
            entry<Screens.Login>
            {
                val viewModel: LoginViewModel = koinViewModel()
                LaunchedEffect(Unit)
                {
                    viewModel.event.collect { event ->
                        when (event) {
                            LoginEvent.NavigateToHome -> {
                                backStack.clear()
                                backStack.add(Screens.Home)
                            }

                            LoginEvent.NavigateToSignup -> {
                                backStack.add(Screens.Signup)
                            }
                        }
                    }

                }
                LoginScreen(
                    state = viewModel.uiState,
                    onIntent = viewModel::onIntent
                )
            }
            entry<Screens.Signup>
            {
                val viewModel: SignupViewModel = koinViewModel()
                LaunchedEffect(Unit)
                {
                    viewModel.event.collect { event ->
                        when (event) {
                            SignUpEvent.OnNavigateToLogin -> {
                                backStack.removeLastOrNull()
                            }

                            SignUpEvent.OnNavigateToHome -> {
                                backStack.clear()
                                backStack.add(Screens.Home)
                            }
                        }
                    }
                }
                SignUpScreen(
                    states = viewModel.uiState,
                    onIntent = viewModel::onIntent
                )
            }
            entry<Screens.Home>
            {
                val viewModel: HomeViewModel = koinViewModel()
                LaunchedEffect(Unit)
                {
                    viewModel.event.collect { event ->
                        when (event) {
                            HomeEvent.OnNavigateToLogin -> {
                                backStack.clear()
                                backStack.add(Screens.Login)
                            }
                        }
                    }
                }
                HomeScreen(
                    state = viewModel.uiState,
                    onIntent = viewModel::onIntent
                )
            }
        }
    )
}