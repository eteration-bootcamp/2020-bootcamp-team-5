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
                <Alert.Heading> 
                    <Spinner animation="border" role="status">
                        <span className="sr-only"></span>
                    </Spinner>
                    Deleting your note... 
                </Alert.Heading>
            </Alert>
            <Button variant="light" onClick={props.onHide}>Close</Button>
        </Modal>
      );

}
  
export default DeleteNote;