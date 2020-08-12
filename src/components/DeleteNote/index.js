import React from 'react';
import {Button, Alert, Modal, Spinner} from 'react-bootstrap';
import {setAllNotes, setDeletingAlertBoxClosed} from '../../actions';
import {useSelector, useDispatch} from 'react-redux';
import axios from 'axios';

function DeleteNote(props) {

    const deletingStatusMessage = useSelector(state => state.deletingStatusMessage);
    const dispatch = useDispatch();

    // If deleting is successful, fetch all notes again.
    function closeButtonOnClick() {
        dispatch(setDeletingAlertBoxClosed());

        axios.get("http://localhost/notes/all", { 'headers': { 'auth': '1234' } })
            .then(res => {
                dispatch(setAllNotes(res.data));
            })
            .catch(error => {
                console.error(error.response);
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

                    {deletingStatusMessage}
                </Alert.Heading>
            </Alert>
            <Button variant="light" onClick={closeButtonOnClick}>Close</Button>
        </Modal>
      );

}
  
export default DeleteNote;