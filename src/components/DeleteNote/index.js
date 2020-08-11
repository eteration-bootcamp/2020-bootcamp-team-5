import React from 'react';
import {Button, Alert, Modal, Spinner} from 'react-bootstrap';

function DeleteNote(props) {
  
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
                    
                <Alert.Heading>Your note is being deleted! 
                    <Spinner animation="border" role="status">
                        <span className="sr-only"></span>
                    </Spinner>
                </Alert.Heading>
                <p>
                    #NoteTitle
                    #NoteText
                </p>

                <Button variant="light" onClick={props.onHide}>Close</Button>
            </Alert>
        </Modal>
      );

}
  
export default DeleteNote;