import React from 'react';
import '../../styles/Main.css';
import {Col, Card, Button} from 'react-bootstrap';
import {PencilSquare, ZoomIn, Trash, Share} from 'react-bootstrap-icons';
import EditNote from '../EditNote';

function Note() {
    const [modalShow, setModalShow] = React.useState(false);

    return (
        <Col xs={12} sm={6} md={4} lg={4} xl={4} className="note-item-col ver-hor-center">
            <Card>
                <Card.Body>
                    <Card.Title>Note</Card.Title>
                    <Card.Text>
                        With supporting text below as a natural lead-in to additional cont.
                    </Card.Text>
                    <Button variant="primary"><ZoomIn/></Button> {' '}
                    <Button variant="warning" onClick={() => setModalShow(true)}><PencilSquare/></Button> {' '}
                    <EditNote
                        show={modalShow}
                        onHide={() => setModalShow(false)}
                    />
                    <Button variant="danger"><Trash/></Button> {' '}
                    <Button variant="info"><Share/></Button>
                </Card.Body>
            </Card>
        </Col>
    );

}

export default Note;