import React, { useState, useEffect } from 'react';
import {Button, Modal, Form, Col} from 'react-bootstrap';
import {useSelector} from 'react-redux';
import axios from 'axios';
import {useDispatch} from 'react-redux';
import {setAllNotes} from '../../actions';
import {setCurrentViewNote} from '../../actions';
import {UPDATE_NOTE_API, ALL_NOTES_API} from '../../config/api';

function EditNote(props) {
    const note = useSelector(state => state.currentNote);
    const [editStatus, setEditStatus] = useState('');
    const dispatch = useDispatch();

    function updateNote() {
      const noteJSON = {
        'id': note.id,
        'title': `${note.title}`,
        'content': `${note.content}`
      }

      axios.put(`${UPDATE_NOTE_API}${note.id}`, noteJSON, { 'headers': { 'auth': '1234' } })
        .then(res => {

          axios.get(ALL_NOTES_API, { 'headers': { 'auth': '1234' } })
            .then(res => {
                dispatch(setAllNotes(res.data));
                setEditStatus("Your note has been updated successfully! => " + noteJSON.title);
            })
            .catch(error => {
                console.error(error.response);
            });

        })
        .catch(error => {
            console.error(error.response);
        });
    }

    function editTitle(e) {
        const newNote = {
          id: `${note.id}`,
          title: e.target.value, 
          content: `${note.content}`
        }

        dispatch(setCurrentViewNote(newNote));
    }

    function editContent(e) {
      const newNote = {
        id: `${note.id}`,
        title: `${note.title}`, 
        content: e.target.value
      }
        
        dispatch(setCurrentViewNote(newNote));
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
            Edit your note: {note.title} {editStatus}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form.Group>
                <Form.Row>
                    <Col>
                      <Form.Control type="text" onChange={e => editTitle(e)} value={note.title} />
                    </Col>
                </Form.Row>
                <br />
                <Form.Row>
                    <Col>
                      <Form.Control componentClass="textarea" rows={100} style={{ height: 200 }}  size="sm" type="text" onChange={e => editContent(e)} value={note.content} />
                    </Col>
                </Form.Row>
            </Form.Group>
        </Modal.Body>
        <Modal.Footer>
            <Button onClick={() => updateNote({note})}>Update</Button>
            <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
}
  
export default EditNote;
