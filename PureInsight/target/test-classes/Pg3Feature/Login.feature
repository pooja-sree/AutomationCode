Feature: Login Functionality

    Scenario Outline: Login with user
        Given I Navigate to Login Page
        When User login "<user>" and "<Email>" and "<password>"
        Then I should be logged in
        Examples:
            | user            | Email                                    | password      |
            | practitioner    | sweadha.d+rdb@spritle.com                | Password@1234 |
            | patient         | karthikeyan.s+dec062023a@spritle.com     | Password@123  |
            | Invalid         | poojasree.k+testing@spritle.com          | Pass          |
            | Empty data      |                                          |               |
            | Forgot Password | poojasree.k+b@spritle.com                | Pass          |