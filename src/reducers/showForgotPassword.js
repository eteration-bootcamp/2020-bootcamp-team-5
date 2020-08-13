const showForgotPassword = (state = false, action) => {
    switch (action.type) {
        case 'SWITCH_FORGOT_REGISTER':
          return !state;
        default:
          return state;
    }
}

export default showForgotPassword;
