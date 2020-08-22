const addNoteBox = (state = false, action) => {
    switch (action.type) {
        case 'SET_ADD_NOTE_BOX_CLOSED':
          return false;
        case 'SET_ADD_NOTE_BOX_OPEN':
          return true;
        default:
          return state;
    }
}

export default addNoteBox;
