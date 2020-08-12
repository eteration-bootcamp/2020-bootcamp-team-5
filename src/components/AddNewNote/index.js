import React, {useState, useRef} from 'react';
import {Button, Modal, Form, Col} from 'react-bootstrap';
import axios from 'axios';
import {useDispatch} from 'react-redux';
import {setAllNotes} from '../../actions';

function AddNewNote(props) {

    const [header, setHeader] = useState('Add a new note!');
    const titleRef = useRef(null);
    const contentRef = useRef(null);

    const dispatch = useDispatch();
    
    /* Localhost will be changed as server ip and headers will be dynamic. */
    function addNote() {
      const noteJSON = {
        'title': `${titleRef.current.value}`,
        'content': `${contentRef.current.value}`
      }

      axios.post('http://localhost/notes/add/', noteJSON, { 'headers': { 'auth': '1234' } })
      .then(res => {

        axios.get("http://localhost/notes/all", { 'headers': { 'auth': '1234' } })
          .then(res => {
              dispatch(setAllNotes(res.data));
          })
          .catch(error => {
              console.error(error.response);
          });
          
          setHeader("Your note has been added successfully! => " + noteJSON.title);
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
                    <Col>
                      <Form.Control ref={contentRef} componentClass="textarea" rows={100} style={{ height: 200 }}  size="sm" type="text" placeholder="Write your note here..." />
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