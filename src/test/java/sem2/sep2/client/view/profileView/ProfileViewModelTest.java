package sem2.sep2.client.view.profileView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sem2.sep2.client.model.register.RegisterModel;
import sem2.sep2.shared.util.Request;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProfileViewModelTest
{
  private ProfileViewModel profileViewModel;
  private RegisterModel registerModelMock;
  @BeforeEach
  public void setUp(){
    registerModelMock = mock(RegisterModel.class);
    profileViewModel = new ProfileViewModel(registerModelMock);
  }

  @Test
  void testChangeUserNameSuccess(){
    // Arrange
    when(registerModelMock.changeUsername(anyString(),anyString())).thenReturn(new Request("Username changed successfully",null));

    //Act
    profileViewModel.getUserName().set("previousUsername");
    profileViewModel.getNewUserName().set("newUsername");
    boolean result = profileViewModel.changeUserName();

    //Assert
    assertTrue(result);
  }
  @Test
  void testChangeUserNameFailed(){
    //Arrange
    when(registerModelMock.changeUsername(anyString(),anyString())).thenReturn(new Request("Username changed failed",null));

    //Act
    profileViewModel.getUserName().set("username");
    profileViewModel.getNewUserName().set("newUsername");
    boolean result = profileViewModel.changeUserName();

    //Assert
    assertFalse(result);
  }
  @Test
  void testChangePasswordSuccessfully(){
    //Arrange
    when(registerModelMock.changePassword(anyString(),anyString())).thenReturn(new Request("Password changed successfully",null));
    //Act
    profileViewModel.getUserNameChangePassword().set("username");
    profileViewModel.getNewPassword().set("newPassword");
    profileViewModel.getAgain().set("newPassword");
    boolean result = profileViewModel.changePassword();
    //Assert
    assertTrue(result);
  }
  @Test
  void testChangePasswordInDifferentNewPassword(){
    //Arrange
    when(registerModelMock.changePassword(anyString(),anyString())).thenReturn(new Request("Password changed successfully",null));
    //Act
    profileViewModel.getUserNameChangePassword().set("username");
    profileViewModel.getNewPassword().set("newPassword");
    profileViewModel.getAgain().set("DifferentPassword");
    boolean result = profileViewModel.changePassword();
    //Assert
    assertFalse(result);
  }
  @Test
  void testChangePasswordInWrongUsername(){
    //Arrange
    when(registerModelMock.changePassword(anyString(),anyString())).thenReturn(new Request("Wrong username",null));
    //Act
    profileViewModel.getUserNameChangePassword().set("wrongUsername");
    profileViewModel.getNewPassword().set("newPassword");
    profileViewModel.getAgain().set("DifferentPassword");
    boolean result = profileViewModel.changePassword();
    //Assert
    assertFalse(result);
  }
  @Test
  void testReset(){
    //Act
    profileViewModel.getUserName().set("username");
    profileViewModel.getNewUserName().set("newUsername");
    profileViewModel.getUserNameChangePassword().set("username");
    profileViewModel.getNewPassword().set("newPassword");
    profileViewModel.getAgain().set("DifferentPassword");
    profileViewModel.reset();
    //Assert
    assertNull(profileViewModel.getUserName().get());
    assertNull(profileViewModel.getNewUserName().get());
    assertNull(profileViewModel.getUserNameChangePassword().get());
    assertNull(profileViewModel.getNewPassword().get());
    assertNull(profileViewModel.getAgain().get());
  }
}