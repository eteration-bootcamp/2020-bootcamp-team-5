const currentNote = (state = {id: -1, title: '', content: ''}, action) => {
    switch (action.type) {
        case 'SET_CURRENT_VIEW_NOTE':
          return action.payload;
        default:
          return state;
    }
}

export default currentNote;