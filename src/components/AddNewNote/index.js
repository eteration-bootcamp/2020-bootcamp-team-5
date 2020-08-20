import React, {useState, useRef} from 'react';
import {Button, Modal, Form, Col} from 'react-bootstrap';
import axios from 'axios';
import {useDispatch} from 'react-redux';
import {setAllNotes} from '../../actions';
import {CREATE_NOTE_API, ALL_NOTES_API} from '../../config/api';
import '../../styles/Main.css';

function AddNewNote(props) {
    const [header, setHeader] = useState('Add a new note!');
    const titleRef = useRef(null);
    const contentRef = useRef(null);
    const dispatch = useDispatch();
    
    function addNote() {
      const noteJSON = {
        'title': `${titleRef.current.value}`,
        'content': `${contentRef.current.value}`
      }

      axios.post(CREATE_NOTE_API, noteJSON, { 'headers': { 'auth': localStorage.getItem('auth') } })
        .then(res => {
          axios.get(ALL_NOTES_API, { 'headers': { 'auth': localStorage.getItem('auth') } })
            .then(res => {
                dispatch(setAllNotes(res.data));
            })
            .catch(error => {
              setHeader(`Something went wrong!`);
            });
            
            setHeader(`Add a new note! Status: Your note (${noteJSON.title}) has been added successfully!`);
        })
        .catch(error => {
          setHeader(`Something went wrong!`);
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
                      <Form.Control ref={titleRef} type="text" placeholder="Note title" />
                    </Col>
                </Form.Row>
                <br />
                <Form.Row>
                    <Col >
                      <Form.Control ref={contentRef} as="textarea" rows="100" style={{ height: 200 }}  size="sm" type="text" placeholder="Write your note here..." />
                    </Col>
                </Form.Row>
            </Form.Group>
        </Modal.Body>
        <Modal.Footer>
            <Button onClick={addNote}>Submit</Button>
            <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
}
  
export default AddNewNote;
