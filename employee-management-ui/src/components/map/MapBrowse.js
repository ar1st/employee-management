import { useEffect, useState } from "react"
import { axiosGet } from "../../lib/axios"
import { GET_ATTRIBUTES_URL, GET_EMPLOYEES_URL } from "../../lib/url/apiUrlConstants"
import LoadingSpinner from "../utils/LoadingSpinner"
import Select from 'react-select'
import MapContainer from "./MapContainer"
import useCatch from "../../hooks/useCatch"

export default function MapBrowser() {
    const [attributes, setAttributes] = useState(null)
    const [employees, setEmployees] = useState(null)
    const [isEmployeeSelected, setEmployeeSelected] = useState(false)
    const [origin, setOrigin] = useState({})
    const [destinations, setDestinations] = useState({})
    const { cWrapper } = useCatch()

    const handleAttributeChange = (value) => {
        setEmployeeSelected(false)

        cWrapper(() =>
            axiosGet(GET_EMPLOYEES_URL,
                { attributeId: value.value }
            ).then(response => {
                setEmployees(response.data.data.map(it => ({ label: it.name, id: it.id, xcoordinate: it.xcoordinate, ycoordinate: it.ycoordinate, car: it.car })))
            })
        )
    }

    const handleEmployeeChange = async (selectedEmployee) => {
        setEmployeeSelected(true)

        setOrigin({ lat: parseFloat(selectedEmployee.xcoordinate), lng: parseFloat(selectedEmployee.ycoordinate), car: selectedEmployee.car })

        setDestinations(employees.filter(it => it.id !== selectedEmployee.id)
            .map(it => ({ lat: parseFloat(it.xcoordinate), lng: parseFloat(it.ycoordinate) }))
        )

    }

    useEffect(() => {
        cWrapper(() =>
            axiosGet(GET_ATTRIBUTES_URL)
                .then(response => {
                    const data = response.data.data;

                    setAttributes(data.map(it => ({ value: it.id, label: `${it.name}: ${it.value}` })))
                })
        )
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    return (
        attributes ? (
            <div className='map-container'>
                {attributes && <>
                    <div className="font-weight-bold mb-2">Select an attribute to filter users</div>
                    <Select
                        instanceId="attributes"
                        placeholder='Select Attribute'
                        options={attributes}
                        onChange={value => handleAttributeChange(value)}
                    />
                </>}
                {employees && <>
                    <div className="font-weight-bold mt-4 mb-2">Select an employee to get distances</div>
                    <Select
                        instanceId="employees"
                        placeholder='Select Employee'
                        options={employees}
                        onChange={value => handleEmployeeChange(value)}
                    />
                </>}
                {isEmployeeSelected && <MapContainer origin={origin} destinations={destinations} />}
            </div>)
            : <LoadingSpinner />
    )
};
