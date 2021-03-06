import React from 'react';
import {Button, Modal} from 'react-bootstrap';
import {useSelector} from 'react-redux';

function ViewNote(props) {
    const note = useSelector(state => state.currentNote);

    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            {note.title}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {note.content}
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
  }
  
export default ViewNote;
