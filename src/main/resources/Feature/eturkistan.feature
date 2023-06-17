Feature: eturkistan feature
  Scenario Outline: user verify added items with subject and content
    Given I launch SDBO
    When I login with username "ab.nurum@gmail.com" and password "123456"
    And I click on SDBO Resource section
    And I click "<itemNum>" item on "<columnNum>" column
    And I select "Add Topic" on source popup
    And I enter "<subject>" on Name , and enter "<content>" to body for add topic
    And I close popup for add topic
    And I click on "<itemNum>" item on "<columnNum>" column
    Then I verify added an item with subject "<subject>" and content "<content>"

    Examples:
      | itemNum | columnNum | subject              | content                      |
      |       2 |         2 | selenium added topic | this is selenium added topic |
      |       1 |         3 | selenium             | this is selenium             |

