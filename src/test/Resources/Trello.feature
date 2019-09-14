Feature: Trello API

  Scenario: Reading Board
    Given I use "69ca272b48ebe66ff934cc6b092897e0" and "1a49b879cdb6d8f739f2ec26e747ff5c5e12871297c0eb9106aff350f54a9c4a"
    When I get board "3nCXKl7N"
    Then Response code is <200>
    But Board privacy is "private"
    # But = And = Then

  Scenario Outline: Reading Boards "<boardId>"
    Given I use "69ca272b48ebe66ff934cc6b092897e0" and "1a49b879cdb6d8f739f2ec26e747ff5c5e12871297c0eb9106aff350f54a9c4a"
    When I get board "<boardId>"
    Then Response code is <200>
    But Board privacy is "private"

    Examples:
      | boardId  |
      | 3nCXKl7N |
      | dRqLC7T2 |
      | Fcm9BHBy |

    Scenario: Creating Board
      Given I use "69ca272b48ebe66ff934cc6b092897e0" and "1a49b879cdb6d8f739f2ec26e747ff5c5e12871297c0eb9106aff350f54a9c4a"
      When I create board "Tralalalal"
      Then Response code is <200>