import React, {useState} from 'react';
import '../../styles/Main.css';
import {Col, Card, Button} from 'react-bootstrap';
import {PencilSquare, ZoomIn, Trash, Share} from 'react-bootstrap-icons';
import EditNote from '../EditNote';
import DeleteNote from '../DeleteNote';
import ShareNote from '../ShareNote';
import ViewNote from '../ViewNote';

function Note() {
    const [modalShow, setModalShow] = useState(false);
    const [alertShow, setAlertShow] = useState(false);
    const [shareShow, setShareShow] = useState(false);
    const [viewShow, setViewShow] = useState(false);

    return (
        <Col xs={12} sm={6} md={4} lg={4} xl={4} className="note-item-col ver-hor-center">
            <Card>
                <Card.Body>
                    <Card.Title>Note</Card.Title>
                    <Card.Text>
                        With supporting text below as a natural lead-in to additional cont.
                    </Card.Text>
                    <Button variant="primary" onClick={() => setViewShow(true)}><ZoomIn/></Button> {' '}
                    <ViewNote
                        show={viewShow}
                        onHide={() => setViewShow(false)}
                    />
                    <Button variant="warning" onClick={() => setModalShow(true)}><PencilSquare/></Button> {' '}
                    <EditNote
                        show={modalShow}
                        onHide={() => setModalShow(false)}
                    />
                    <Button variant="danger" onClick={() => setAlertShow(true)}><Trash/></Button> {' '}
                    <DeleteNote
                        show={alertShow}
                        onHide={() => setAlertShow(false)}
                    />
                    <Button variant="info" onClick={() => setShareShow(true)}><Share/></Button>
                    <ShareNote
                        show={shareShow}
                        onHide={() => setShareShow(false)}
                    />
                </Card.Body>
            </Card>
        </Col>
    );

}

export default Note;