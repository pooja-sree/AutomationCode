Feature: Add New Patient

  Background:
    Given I navigate to login page


#  Scenario Outline: Login and Add a New Patient With Different users
#    When User login "<user>" and "<username>" and "<password>"
#    When I click on add new patient and enter Patient Details "<usertype>"
#    And Click on Cancel and continue
#
#    Examples:
#      | usertype       | user           | username                                | password      |
#      | practice admin | practice admin | 	poojasree.k+revadmin@spritle.com      |  Password@123  |
#      | practitioner   | practitioner   | poojasree.k+revpract@spritle.com  | Password@123 |


  Scenario Outline: Login and Cancel and add New Patient With Different Users.
    When User login "<user>" and "<username>" and "<password>"
    When I click on add new patient and enter Patient Details "<usertype>"
    And Cancel
    And Click on Add Patient

    Examples:
      | usertype       | user           | username                                | password      |
      | practice admin | practice admin | 	poojasree.k+revadmin@spritle.com      |  Password@123  |
      | practitioner   | practitioner   | poojasree.k+revpract@spritle.com  | Password@123 |


#  Scenario Outline: Add Patient only with email
#    When User login "<user>" and "<username>" and "<password>"
#    And I click on add new patient and click on Add "<usertype>"
#    Then Patient should be added
#
#    Examples:
#      | usertype       | user           | username                                | password      |
#      | practice admin | practice admin | 	poojasree.k+revadmin@spritle.com      |  Password@123  |
#      | practitioner   | practitioner   | poojasree.k+revpract@spritle.com  | Password@123 |
#
#  Scenario Outline: Add Patient without any data
#    When User login "<user>" and "<username>" and "<password>"
#    And  Click on Add without adding email "<usertype>"
#
#    Examples:
#      | usertype       | user           | username                                | password      |
#      | practice admin | practice admin | 	poojasree.k+revadmin@spritle.com      |  Password@123  |
#      | practitioner   | practitioner   | poojasree.k+revpract@spritle.com   | Password@123 |
#
#
#  Scenario Outline: Add Patient with registered email
#    When User login "<user>" and "<username>" and "<password>"
#    And  Click on Add by entering registered email "<usertype>"
#
#    Examples:
#      | usertype       | user           | username                                | password      |
#      | practice admin | practice admin | 	poojasree.k+revadmin@spritle.com      |  Password@123  |
#      | practitioner   | practitioner   | poojasree.k+revpract@spritle.com   | Password@123 |

