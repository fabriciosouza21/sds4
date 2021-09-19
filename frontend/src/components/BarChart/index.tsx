import axios from 'axios'
import { useEffect, useState } from 'react'
import Chat from 'react-apexcharts'
import { SaleSucess } from 'types/sale'
import { round } from 'utils/Format'
import { BASE_URL } from 'utils/Request'

type SeriesData = {
    name:string;
    data:number[]
}

type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[]
}
const Barchart = () => {
    
    const [chatrData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []                   
            }
        ]
    })

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/sucess-by-seller`)
            .then(response => {

                const data = response.data as SaleSucess[]
                const myLabels = data.map((x) => x.sellerName)
                const mySeries = data.map((x) => round(100 * x.deals/x.visited,1))
                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Sucess",
                            data: mySeries                   
                        }
                    ]
                })
            })
    }, [])
    
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

   
    return (

        <Chat 
        options ={{...options,xaxis: chatrData.labels,}}
        series = {chatrData.series}
        type = 'bar'
        height = '240'

        />

    );
}

export default Barchart ;