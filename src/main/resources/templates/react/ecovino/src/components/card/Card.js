
const Card = ({name, logo, ddo, img, description, link = '',setTarget,productos })=> {

    const action =()=>{
        setTarget([...productos])
    }

    return <div className='card'>
        <div className="cardHeader">
            <img  src={logo} className="cardLogo" alt='' />
            <div className="cardHeaderData">
                <div className="name">
                    <strong>{name}</strong>
                </div>
                <div className="ddo">
                    DO: {ddo}
                </div>
            </div>
        </div>
        <div className="cardBody">
            <div className="cardImage">
            </div>
            <div className="cardDescription">
                {description}
            </div>
        </div>
        <div className="cardFooter">
            <button onClick={action}>
                Vinos
            </button>
        </div>
    </div>
}

export { Card };