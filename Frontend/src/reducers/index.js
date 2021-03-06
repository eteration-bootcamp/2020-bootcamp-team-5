import showForgotPassword from './showForgotPassword';
import currentNote from './currentNote';
import allNotes from './allNotes';
import deletingStatusMessage from './deletingStatusMessage';
import deletingAlertBox from './deletingAlertBox';
import showToast from './showToast';
import toastContent from './toastContent';
import toastTitle from './toastTitle';
import addNoteBox from './addNoteBox';
import editNoteBox from './editNoteBox';
import {combineReducers} from 'redux';

const reducer = combineReducers({
    showForgotPassword,
    currentNote,
    allNotes,
    deletingStatusMessage,
    deletingAlertBox,
    showToast,
    toastContent,
    toastTitle,
    addNoteBox,
    editNoteBox
});

export default reducer;
