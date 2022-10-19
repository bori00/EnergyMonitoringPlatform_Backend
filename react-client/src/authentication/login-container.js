import React, { useState, useEffect } from 'react';
import { Button, Card, CardHeader, Col, Modal, ModalBody, ModalHeader, Row } from 'reactstrap';

import APIResponseErrorMessage from "../commons/errorhandling/api-response-error-message";

import LoginForm from "./login-form";

function LoginContainer() {
    return (
        <div>
            <CardHeader>
                <strong> Login </strong>
            </CardHeader>

            <Card>
                <br />
                <Row>
                    <Col sm={{ size: '8', offset: 1 }}>
                        <LoginForm />
                    </Col>
                </Row>
                {/*</Row>*/}
                {/*<br />*/}
                {/*<Row>*/}
                {/*    <Col sm={{ size: '8', offset: 1 }}>*/}
                {/*        {isLoaded && <PersonTable tableData={tableData} />}*/}
                {/*        {error.status > 0 &&*/}
                {/*        <APIResponseErrorMessage*/}
                {/*            errorStatus={error.status}*/}
                {/*            error={error.errorMessage}*/}
                {/*        />}*/}
                {/*    </Col>*/}
                {/*</Row>*/}

            </Card>

            {/*<Modal isOpen={isSelected} toggle={toggleForm} size="lg">*/}
            {/*    <ModalHeader toggle={toggleForm}> Add Person: </ModalHeader>*/}
            {/*    <ModalBody>*/}
            {/*        <PersonForm reloadHandler={reload} />*/}
            {/*    </ModalBody>*/}
            {/*</Modal>*/}

        </div>
    );

}

export default LoginContainer;
