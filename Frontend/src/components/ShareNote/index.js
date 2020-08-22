import React, { useRef, useState } from 'react';
import {Form, Col, Button, Modal} from 'react-bootstrap';
import {SHARE_NOTE_API} from '../../config/api';
import axios from 'axios';
import {useSelector} from 'react-redux';

function ShareNote(props) {
    const usernameRef = useRef(null);
    const readPermissionRef = useRef(null);
    const writePermissionRef = useRef(null);
    const note = useSelector(state => state.currentNote);
    const [header, setHeader] = useState('Share your note!');

    function shareNote() {
      const permission = readPermissionRef.current.checked ? 0 : 1;
      
      axios.post(`${SHARE_NOTE_API}${note.id}/${usernameRef.current.value}/${permission}` , {}, { 'headers': { 'auth': localStorage.getItem('auth') } })
        .then(res => {
          setHeader(`Share your note! Status: Your note (${note.title}) has been shared successfully!`);
        })
        .catch(error => {
          setHeader("Share your note! Status: You have no sharing authority for this note or username not found!");
        });
    }

    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            {header}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Group>
              <Form.Row>
                  <Col>
                    <Form.Control type="text" placeholder="Write username here that you want to share note with." ref={usernameRef}/>
                  </Col>
              </Form.Row>
              <br />
              <Form.Row>
                  <Col>
                    <span>Select Role:</span>
                    <Form.Check
                      type="radio"
                      label="Read"
                      name="formHorizontalRadios"
                      id="formHorizontalRadios1"
                      ref={readPermissionRef}
                    />
                    <Form.Check
                      type="radio"
                      label="Write"
                      name="formHorizontalRadios"
                      id="formHorizontalRadios2"
                      ref={writePermissionRef}
                    />
                  </Col>
              </Form.Row>
            </Form.Group> 
        </Modal.Body>
        <Modal.Footer>
            <Button onClick={() => shareNote()}>Share</Button>
            <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
  }
  
export default ShareNote;
