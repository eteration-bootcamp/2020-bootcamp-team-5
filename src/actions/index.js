export function switchForgotRegister() {
    return {
        type: "SWITCH_FORGOT_REGISTER"
    };
};

export function setCurrentViewNote(note) {
    return {
        type: "SET_CURRENT_VIEW_NOTE",
        payload: note
    };
};

export function setAllNotes(allNotes) {
    return {
        type: "SET_ALL_NOTES",
        payload: allNotes
    };
};

export function setDeletingStatusDeleted() {
    return {
        type: "SET_DELETING_STATUS_DELETED"
    };
};

export function setDeletingStatusNoAuthory() {
    return {
        type: "SET_DELETING_STATUS_NO_AUTHORY"
    };
};

export function setDeletingAlertBoxClosed() {
    return {
        type: "SET_DELETING_ALERT_BOX_CLOSED"
    };
};

export function setDeletingAlertBoxOpen() {
    return {
        type: "SET_DELETING_ALERT_BOX_OPEN"
    };
};

export function showToastBox() {
    return {
        type: "SHOW_TOAST_BOX"
    };
};

export function closeToastBox() {
    return {
        type: "CLOSE_TOAST_BOX"
    };
}

export function setToastTitle(title) {
    return {
        type: "SET_TOAST_TITLE",
        payload: title
    };
}

export function setToastContent(content) {
    return {
        type: "SET_TOAST_CONTENT",
        payload: content
    };
}
