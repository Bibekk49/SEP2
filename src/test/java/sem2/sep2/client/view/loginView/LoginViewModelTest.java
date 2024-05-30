package sem2.sep2.client.view.loginView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.register.RegisterModel;
import sem2.sep2.shared.util.Request;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginViewModelTest
{
  private LoginModel loginModelMock;
  private RegisterModel registerModelMock;
  private LoginViewModel loginViewModel;

  @BeforeEach
  public void setUp() {
    loginModelMock = mock(LoginModel.class);
    registerModelMock = mock(RegisterModel.class);
    loginViewModel = new LoginViewModel(loginModelMock, registerModelMock);
  }
  @Test
  void testRegisterSuccess(){
    //Arrange
    when(registerModelMock.addUser(anyString(), anyString())).thenReturn(new Request("User created successfully", null));;
    // Act
    loginViewModel.usernameProperty().set("username");
    loginViewModel.passwordPorperty().set("password");
    Request result = loginViewModel.register();
    // Assert
    assertEquals("User created successfully", result.getType());
  }
  @Test
  void testRegisterFailed() {
    //arrange
    when(registerModelMock.addUser(anyString(), anyString())).thenThrow(new IllegalArgumentException("Invalid username or password"));
    //act
    loginViewModel.usernameProperty().set("username");
    loginViewModel.passwordPorperty().set("password");
    Request result = loginViewModel.register();
    //assert
    // testRegisterFailed
    assertNull(result);
    assertEquals("Invalid username or password", loginViewModel.errorTextProperty().get());
  }
  @Test
  void testLoginSuccess(){
    //arrange
    when(loginModelMock.login(anyString(),anyString())).thenReturn(new Request("Login successfully",null));
    //act
    loginViewModel.usernameProperty().set("username");
    loginViewModel.passwordPorperty().set("password");
    Request result = loginViewModel.login();
    //assert
    assertEquals("Login successfully",result.getType());
  }
  @Test
  void testLoginFailed(){
    //arrange
    when(loginModelMock.login(anyString(),anyString())).thenThrow(new IllegalArgumentException("Invalid username or password"));
    //act
    loginViewModel.usernameProperty().set("username");
    loginViewModel.passwordPorperty().set("password");
    Request result = loginViewModel.login();
    //assert
    assertNull(result);
    assertEquals("Invalid username or password",loginViewModel.errorTextProperty().get());
  }
  @Test
  void testReset(){
    //act
    loginViewModel.usernameProperty().set("username");
    loginViewModel.passwordPorperty().set("password");
    loginViewModel.reset();
    //assert
    assertNull(loginViewModel.usernameProperty().get());
    assertNull(loginViewModel.passwordPorperty().get());
  }
}