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

            <Form.Text className="text-muted form-login-forgot-password">
                <Button variant="secondary" className="button-reset" onClick={() => dispatch({ type: 'SWITCH_FORGOT_REGISTER' })}>← Go Back</Button>
            </Form.Text>
        </div>
    );
}

export default ForgotPassword;