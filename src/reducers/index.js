import showForgotPassword from './showForgotPassword';
import currentNote from './currentNote';
import allNotes from './allNotes';
import deletingStatusMessage from './deletingStatusMessage';
import deletingAlertBox from './deletingAlertBox';
import {combineReducers} from 'redux';

const reducer = combineReducers({
    showForgotPassword,
    currentNote,
    allNotes,
    deletingStatusMessage,
    deletingAlertBox
});

export default reducer;
