const toastTitle = (state = '', action) => {
    switch (action.type) {
        case 'SET_TOAST_TITLE':
          return action.payload;
        default:
          return state;
    }
}

export default toastTitle;
