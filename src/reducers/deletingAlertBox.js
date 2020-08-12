const deletingAlertBox = (state = false, action) => {
    switch (action.type) {
        case 'SET_DELETING_ALERT_BOX_CLOSED':
          return false;
        case 'SET_DELETING_ALERT_BOX_OPEN':
          return true;
        default:
          return state;
    }
}

export default deletingAlertBox;