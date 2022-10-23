import React  from 'react';
import {Card, CardHeader, Col, Row } from 'reactstrap';

import AdminDeviceList from "./admin-device-list";

function AdminDeviceManagementContainer() {
    return (
        <div>
            <CardHeader>
                <strong>Device Management</strong>
            </CardHeader>

            <Card>
                <br />
                <Row>
                    <Col sm={{ size: '8', offset: 1 }}>
                        <AdminDeviceList />
                    </Col>
                </Row>

            </Card>

        </div>
    );

}

export default AdminDeviceManagementContainer;
