const deletingStatusMessage = (state = 'Deleting your note...', action) => {
    switch (action.type) {
        case 'SET_DELETING_STATUS_DELETED':
          return 'Your note has been deleted.';
        case 'SET_DELETING_STATUS_NO_AUTHORY':
            return ' You have no deleting authority for this note!';
        case 'SET_DELETING_STATUS_ERROR':
            return ' Something went wrong!';
        default:
          return state;
    }
}

export default deletingStatusMessage;
