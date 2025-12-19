package com.migrosone.mobiletestautomation

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MigrosSmokeTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()


    private fun clickButton(text: String) {
        composeRule
            .onAllNodesWithText(text)
            .filterToOne(hasClickAction())
            .performClick()
    }

    private fun waitText(text: String, timeoutMillis: Long = 5_000) {
        composeRule.waitUntil(timeoutMillis) {
            composeRule.onAllNodesWithText(text).fetchSemanticsNodes().isNotEmpty()
        }
    }


    private fun waitClickableText(text: String, timeoutMillis: Long = 5_000) {
        composeRule.waitUntil(timeoutMillis) {
            composeRule.onAllNodesWithText(text)
                .filter(hasClickAction())
                .fetchSemanticsNodes().isNotEmpty()
        }
    }

    @Test
    fun initialScreen_shouldShowSignInAndSignUpButtons() {

        composeRule.onAllNodesWithText("Sign In")
            .filterToOne(hasClickAction())
            .assertIsDisplayed()

        composeRule.onAllNodesWithText("Sign Up")
            .filterToOne(hasClickAction())
            .assertIsDisplayed()
    }

    @Test
    fun signUp_shouldShowMembershipSuccessfulScreen() {
        val email = "user${System.currentTimeMillis()}@mail.com"
        val password = "123456"
        val name = "Migros Test"

        clickButton("Sign Up")

        composeRule.onNodeWithText("Email").performTextInput(email)
        composeRule.onNodeWithText("Password").performTextInput(password)
        composeRule.onNodeWithText("Name").performTextInput(name)

        clickButton("Sign Up")


        waitText("Membership successful!")
        composeRule.onNodeWithText("Membership successful!").assertIsDisplayed()


        waitClickableText("Sign In Now")
        composeRule.onAllNodesWithText("Sign In Now")
            .filterToOne(hasClickAction())
            .assertIsDisplayed()
    }

    @Test
    fun signUp_thenSignIn_shouldNavigateToProfileAndShowSignOut() {
        val email = "user${System.currentTimeMillis()}@mail.com"
        val password = "123456"
        val name = "test123"


        clickButton("Sign Up")

        composeRule.onNodeWithText("Email").performTextInput(email)
        composeRule.onNodeWithText("Password").performTextInput(password)
        composeRule.onNodeWithText("Name").performTextInput(name)

        clickButton("Sign Up")


        waitText("Membership successful!")
        clickButton("Sign In Now")

        composeRule.onNodeWithText("Email").performTextInput(email)
        composeRule.onNodeWithText("Password").performTextInput(password)
        clickButton("Sign In")


        waitText("Sign Out")
        composeRule.onNodeWithText("Sign Out").assertIsDisplayed()


        composeRule.onNodeWithText("Welcome", substring = true).assertIsDisplayed()
    }
}
