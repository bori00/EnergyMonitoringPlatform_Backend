import React, {useEffect, Fragment, useState} from 'react';
import {
    ListGroup,
    ListGroupItem,
    ListGroupItemText,
    ListGroupItemHeading,
    Button
} from 'reactstrap';

import * as API_DEVICES from "./api/admin-device-api";
import APIResponseErrorMessage from "../commons/errorhandling/api-response-error-message";
import ManageDeviceModal from "./manage-device-modal";
import CreateDeviceModal from "./add-device-modal";

function AdminDeviceList() {

    const [error, setError] = useState({ status: 0, errorMessage: null });
    const [devices, setDevices] = useState([]);
    const [selectedDevice, setSelectedDevice] = useState(null);
    const [addDeviceIntention, setAddDeviceIntention] = useState(0);

    function deviceSelected(device) {
        setSelectedDevice(device)
    }

    function onAddDeviceIntention() {
        setAddDeviceIntention(1);
    }

    useEffect(() => {
        API_DEVICES.getAllDevices((result, status, err) => {
            if (result !== null && (status === 200 || status === 201)) {
                let devices = [];
                result.forEach(device => {
                    devices.push(
                        <ListGroupItem key={device.id} action onClick={() => deviceSelected(device)}>
                            <ListGroupItemHeading>{device.name}</ListGroupItemHeading>
                            <ListGroupItemText>{device.userName}</ListGroupItemText>
                        </ListGroupItem>
                    )
                })

                setDevices(devices);
            } else {
                setError((error) => ({ status: status, errorMessage: err }));
            }
        })
    }, [selectedDevice, addDeviceIntention])

    return (
        <Fragment>
            <ListGroup>
                {devices}
            </ListGroup>

            <Button color="info" onClick={() => onAddDeviceIntention()}>New</Button>

            {
                error.status > 0 &&
                <APIResponseErrorMessage errorStatus={error.status} error={error.errorMessage} />
            }

            {
                selectedDevice !== null &&
                <ManageDeviceModal device={selectedDevice} onClose={() => {setSelectedDevice(null)}}/>
            }

            {
                addDeviceIntention === 1 &&
                <CreateDeviceModal onClose={() => {setAddDeviceIntention(0)}}/>
            }
        </Fragment>
    );

}

export default AdminDeviceList;
