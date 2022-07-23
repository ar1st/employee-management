
import { useJsApiLoader, GoogleMap, Marker, DirectionsRenderer } from '@react-google-maps/api'
import LoadingSpinner from '../utils/LoadingSpinner'
import { useEffect, useState } from 'react'

const center = { lat: 40.638103, lng: 22.945167 }
const originMarkerIcon = 'http://maps.google.com/mapfiles/kml/pushpin/ltblu-pushpin.png'
const libraries = ['places']

export default function MapContainer({ origin, destinations }) {
    const [map, setMap] = useState(/** @type google.maps.Map */(null))
    const { isLoaded } = useJsApiLoader({
        googleMapsApiKey: process.env.REACT_APP_GOOGLE_MAPS_API_KEY,
        libraries
    })
    const [spots, setSpots] = useState([])

    const handleGoogleMapsResponse = (response, status) => {
        if (status === 'OK') {
            var directionsDisplay = new window.google.maps.DirectionsRenderer({ preserveViewport: true });
            directionsDisplay.setMap(map);
            directionsDisplay.setDirections(response);

            setSpots(previous => [
                ...previous,
                directionsDisplay
            ])
        } else {
            window.alert('Directions request failed due to ' + status);
        }
    }

    const calculateRoute = async () => {
        const directionsService = new window.google.maps.DirectionsService()

        const travelMode = origin.car ? 'DRIVING' : 'WALKING'
        destinations.forEach(function (it, index) {
            directionsService.route({
                origin: { lat: origin.lat, lng: origin.lng },
                destination: { lat: it.lat, lng: it.lng },
                travelMode

            }, handleGoogleMapsResponse);
        });
    }

    useEffect(() => {
        calculateRoute()

        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [map])

    if (!isLoaded) {
        return <LoadingSpinner />
    }

    return (
        isLoaded && <div className='map-container'>
            <GoogleMap
                center={center}
                zoom={15}
                mapContainerStyle={{ width: '100%', height: '100%' }}
                options={{
                    zoomControl: false,
                    streetViewControl: false,
                    mapTypeControl: false,
                    fullscreenControl: false,
                }}
                onLoad={(map) => setTimeout(() => setMap(map))}
            >
                {map && <Marker icon={originMarkerIcon} position={{ lat: origin.lat, lng: origin.lng }} />}
                {spots.length > 0 && spots.map(it => <DirectionsRenderer directions={it} />)}

            </GoogleMap>
        </div>
    )
};