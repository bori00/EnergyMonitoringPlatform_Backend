import React  from 'react';
import {Card, CardHeader, Col, Row } from 'reactstrap';

import AdminUserList from "./admin-user-list";

function AdminUserManagementContainer() {
    return (
        <div>
            <CardHeader>
                <strong>User Management</strong>
            </CardHeader>

            <Card>
                <br />
                <Row>
                    <Col sm={{ size: '8', offset: 1 }}>
                        <AdminUserList />
                    </Col>
                </Row>

            </Card>

        </div>
    );

}

export default AdminUserManagementContainer;
