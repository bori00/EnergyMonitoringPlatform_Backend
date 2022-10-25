import React  from 'react';
import {Card, CardHeader, Col, Row } from 'reactstrap';

import ClientDeviceList from "./client-device-list"

function ClientDeviceMonitoringContainer() {
    return (
        <div>
            <CardHeader>
                <strong>Device Monitoring</strong>
            </CardHeader>

            <Card>
                <br />
                <Row>
                    <Col sm={{ size: '8', offset: 1 }}>
                        <ClientDeviceList />
                    </Col>
                </Row>

            </Card>

        </div>
    );

}

export default ClientDeviceMonitoringContainer;
