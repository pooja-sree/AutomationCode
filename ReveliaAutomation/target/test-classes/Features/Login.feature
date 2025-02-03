Feature: User Login

  Scenario Outline: Validate users login with valid and invalid input
    Given the user is on the login page
    When they enter valid "<username>" and "<password>" and login
    Then validate the user login "<users>"

    Examples:
      |username|password|users|
      |vigneswari.s+jm@spritle.com|Password@123|Practitioner|

