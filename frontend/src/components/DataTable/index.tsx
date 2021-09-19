import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/Format";
import { BASE_URL } from "utils/Request";

const DataTable = () => {
    
    const [page, setPage] = useState<SalePage>({
        last:true,
        first: true,
        number:0,
        totalElements:0,
        totalPages:0
    })

    useEffect(()=>{
        axios.get(`${BASE_URL}/sales?page=1&linesPerPage=20&orderBy=date&direction=DESC`).then(
            response => {
                setPage(response.data)
            }
        )
    },[])
    return (
        <div className="table-responsive">
    <table className="table table-striped table-sm">
        <thead>
            <tr>
                <th>Data</th>
                <th>Vendedor</th>
                <th>Clientes visitados</th>
                <th>Negócios fechados</th>
                <th>Valor</th>
            </tr>
        </thead>
        <tbody>
            {page.content?.map(item => (
                <tr key= {item.id}>
                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                <td>{item.seller.name}</td>
                <td>{item.visited}</td>
                <td>{item.deals}</td>
                <td>{item.amount}</td>
            </tr>
            ))}              
        </tbody>
    </table>
</div>

    );
}

export default DataTable;