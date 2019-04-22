package lahendus_aun

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/tekst/tekst")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
