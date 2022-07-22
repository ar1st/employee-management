
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { useState, useEffect } from 'react';
import LoadingSpinner from '../utils/LoadingSpinner';
import { axiosGet, axiosDelete } from '../../lib/axios';
import { GET_ATTRIBUTES_URL, DELETE_ATTRIBUTE_URL } from '../../lib/url/apiUrlConstants';
import { Link } from 'react-router-dom';
import { Button } from 'react-bootstrap';
import { useAlert } from '../utils/GlobalAlert';
import { SAVE_ATTRIBUTE_PAGE_URL } from '../../lib/url/pageUrlConstants';
import useCatch from '../../hooks/useCatch';

export default function AttributesTable() {
    const [tableData, setTableData] = useState(null)
    const { setAlert } = useAlert()
    const { cWrapper } = useCatch()

    const handleDelete = (rowData) => {
        cWrapper(() =>
            axiosDelete(DELETE_ATTRIBUTE_URL(rowData.id))
                .then(() => {
                    setTableData(previous => previous.filter(it => it.id !== rowData.id))
                    setAlert({
                        message: 'Attribute deleted',
                        status: 'success'
                    })
                })
        )
    }
    const actionsColumnBody = (rowData) => {
        return (
            <>

                <Button variant="link">
                    <Link to={SAVE_ATTRIBUTE_PAGE_URL} state={{ id: rowData.id }}>
                        Edit
                    </Link>
                </Button>

                <Button variant='link' onClick={() => handleDelete(rowData)}>
                    Delete
                </Button>

            </>

        )
    }

    useEffect(() => {
        cWrapper(() =>
            axiosGet(GET_ATTRIBUTES_URL)
                .then(response => {
                    const data = response.data.data;

                    setTableData(data)
                })
        )
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    return (
        tableData ? <div >
            <DataTable value={tableData} responsiveLayout="scroll" >
                <Column field="name" header="Name" className='table-row'></Column>
                <Column field="value" header="Value" className='table-row'></Column>
                <Column field="actions" header="" className='table-row' body={actionsColumnBody}></Column>
            </DataTable>
        </div>
            : <LoadingSpinner />

    )
}