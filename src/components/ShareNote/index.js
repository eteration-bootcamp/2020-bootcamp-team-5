import React from 'react';
import {Form, Col, Button, Modal} from 'react-bootstrap';

function ShareNote(props) {

    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            Share your note: {props.title}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Group>
              <Form.Row>
                  <Col>
                    <Form.Control type="text" placeholder="Write username here that you want to share note with." />
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
                    />
                    <Form.Check
                      type="radio"
                      label="Write"
                      name="formHorizontalRadios"
                      id="formHorizontalRadios2"
                    />
                    <Form.Check
                      type="radio"
                      label="Owner"
                      name="formHorizontalRadios"
                      id="formHorizontalRadios3"
                    />
                  </Col>
              </Form.Row>
            </Form.Group> 
        </Modal.Body>
        <Modal.Footer>
            <Button onClick={props.onHide}>Share</Button>
            <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
  }
  
export default ShareNote;