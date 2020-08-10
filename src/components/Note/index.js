import React from 'react';
import '../../styles/Main.css';
import {Col, Card, Button} from 'react-bootstrap';
import {PencilSquare, ZoomIn, Trash, Share} from 'react-bootstrap-icons';
import { useHistory } from "react-router-dom";

function Note() {
    const history = useHistory();

    const routeChange = () =>{ 
      let path = '/notes/add'; 
      history.push(path);
    }

    return (
        <Col xs={12} sm={6} md={4} lg={4} xl={4} className="note-item-col ver-hor-center">
            <Card>
                <Card.Body>
                    <Card.Title>Note</Card.Title>
                    <Card.Text>
                        With supporting text below as a natural lead-in to additional cont.
                    </Card.Text>
                    <Button variant="primary"><ZoomIn/></Button> {' '}
                    <Button variant="warning"><PencilSquare/></Button> {' '}
                    <Button variant="danger"><Trash/></Button> {' '}
                    <Button variant="info"><Share/></Button>
                </Card.Body>
            </Card>
        </Col>
    );

}

export default Note;