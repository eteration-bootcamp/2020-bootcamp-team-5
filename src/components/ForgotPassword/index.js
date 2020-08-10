import React from 'react';
import {Form, Button} from 'react-bootstrap';
import {useDispatch} from 'react-redux';
import '../../styles/Main.css';

function ForgotPassword() {
    const dispatch = useDispatch();
    
    return(
        <div>
            <Form className="form-auth-margin-top">
                <h2>Password Reset</h2>
                <Form.Group controlId="email">
                    <Form.Control placeholder="Enter your email here" />
                </Form.Group>

                <Button variant="dark" type="submit">
                    Reset
                </Button>
            </Form>

            <Form.Text className="text-muted">
                <Button variant="secondary" className="forgot-password-text go-back-button" onClick={() => dispatch({ type: 'SWITCH_FORGOT_REGISTER' })}>← Go Back</Button>
            </Form.Text>
        </div>
    );
}

export default ForgotPassword;