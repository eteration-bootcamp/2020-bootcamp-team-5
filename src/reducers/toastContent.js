const toastContent = (state = '', action) => {
    switch (action.type) {
        case 'SET_TOAST_CONTENT':
          return action.payload;
        default:
          return state;
    }
}

export default toastContent;
