const showToast = (state = false, action) => {
    switch (action.type) {
        case 'SHOW_TOAST_BOX':
          return true;
        case 'CLOSE_TOAST_BOX':
          return false;
        default:
          return state;
    }
}

export default showToast;
