import React from 'react';
import {Button, Modal, Form, Col} from 'react-bootstrap';

function AddNewNote(props) {
    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            Add a new note!
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form.Group>
                <Form.Row>
                    <Col>
                    <Form.Control type="text" placeholder="Note title" />
                    </Col>
                </Form.Row>
                <br />
                <Form.Row>
                    <Col>
                    <Form.Control componentClass="textarea" rows={100} style={{ height: 200 }}  size="sm" type="text" placeholder="Edit your note" />
                    </Col>
                </Form.Row>
            </Form.Group>
        </Modal.Body>
        <Modal.Footer>
            <Button onClick={props.onHide}>Submit</Button>
            <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
  }
  
export default AddNewNote;