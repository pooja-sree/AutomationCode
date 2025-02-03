Feature: Login Functionality

  Scenario Outline: Login with user
    Given I navigate to login page
    When User login "<user>" and "<username>" and "<password>"
    Then I should be logged in
    Examples:
      | user            | username                                    | password      |
      | practice admin  | 	poojasree.k+revadmin@spritle.com          | Password@123  |
      | practitioner    |    poojasree.k+revpract@spritle.com         | Password@123  |
      | patient         | poojasree.k+autotwo@spritle.com             | Password@123  |
      | Invalid         | poojasree.k+testautopract@spritle.com       | Pass          |
      | Empty data      |                                             |               |
      | Nonexistent     | Poojasree.k+lc@spritle.com                  | 123@Password  |
      | Forgot Password | poojasree.k@spritle.com                     |               |