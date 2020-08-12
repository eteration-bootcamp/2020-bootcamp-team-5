const deletingStatusMessage = (state = 'Deleting your note...', action) => {
    switch (action.type) {
        case 'SET_DELETING_STATUS_DELETED':
          return 'Your note has been deleted.';
        default:
          return state;
    }
}

export default deletingStatusMessage;