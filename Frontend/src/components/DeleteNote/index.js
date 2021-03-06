import React from 'react';
import {Button, Alert, Modal, Spinner} from 'react-bootstrap';
import {setAllNotes, setDeletingAlertBoxClosed, setDeletingStatusError} from '../../actions';
import {useSelector, useDispatch} from 'react-redux';
import axios from 'axios';
import {ALL_NOTES_API} from '../../config/api';

function DeleteNote(props) {
    const deletingStatusMessage = useSelector(state => state.deletingStatusMessage);
    const dispatch = useDispatch();

    function closeButtonOnClick() {
        dispatch(setDeletingAlertBoxClosed());

        axios.get(ALL_NOTES_API, { 'headers': { 'auth': localStorage.getItem('auth') } })
            .then(res => {
                dispatch(setAllNotes(res.data));
            })
            .catch(error => {
                dispatch(setDeletingStatusError());
            });
    }

    return (
        <Modal
            {...props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Alert
                {...props}
                variant="danger">
                <Alert.Heading> 
                    <Spinner animation="border" role="status">
                        <span className="sr-only"></span>
                    </Spinner>

                    {' '} {deletingStatusMessage}
                </Alert.Heading>
            </Alert>
            <Button variant="light" onClick={closeButtonOnClick}>Close</Button>
        </Modal>
    );
}
  
export default DeleteNote;
