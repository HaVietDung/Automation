# mvn verify -Dtestsuite=LoginTestSuite -Dtags=@login
# mvn serenity:aggregate

@login
Feature: Login

  Scenario Outline: Đăng nhập vào trang SSO AEM
    Given Auto open url <url>
    When SSO - Input email = <email>, pass = <pass> and sign in
    Given Auto open url <url>

    Then SSO - Check login success and my lg page display
    And SSO - Get auth token

    Examples:
      | url                          | email                         | pass      |
      | https://www.lg.com/uk/login/ | kimvt_uk_b2c_prod@yopmail.com | Hg281291@ |
