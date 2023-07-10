package com.example.dynamicapplication

object JsonData {

    const val jsonData = """{
	"menu": [{
			"id": 1,
			"name": "Page 1"
		},
		{
			"id": 2,
			"name": "Page 2"
		},
		{
			"id": 3,
			"name": "Page 3"
		},
		{
			"id": 4,
			"name": "Page 4"
		},
		{
			"id": 5,
			"name": "Page 5"
		}
	],
	"pages": [{
			"id": 1,
			"name": "Page 1",
			"elements": [{
					"type": "button",
					"label": "Click me",
					"action": "submit"
				},
				{
					"type": "image",
					"url": "https://example.com/image.jpg",
					"alt": "Example image"
				},
				{
					"type": "text",
					"content": "Welcome to Page 1"
				}
			]
		},
		{
			"id": 2,
			"name": "Page 2",
			"elements": [{
					"type": "button",
					"label": "Submit",
					"action": "submit"
				},
				{
					"type": "image",
					"url": "https://example.com/image2.jpg",
					"alt": "Example image 2"
				},
				{
					"type": "text",
					"content": "Page 2 content"
				}
			]
		},
		{
			"id": 3,
			"name": "Page 3",
			"elements": [{
					"type": "button",
					"label": "Next",
					"action": "next"
				},
				{
					"type": "image",
					"url": "https://example.com/image3.jpg",
					"alt": "Example image 3"
				},
				{
					"type": "text",
					"content": "Page 3 text"
				}
			]
		},
		{
			"id": 4,
			"name": "Page 4",
			"elements": [{
					"type": "button",
					"label": "Back",
					"action": "back"
				},
				{
					"type": "image",
					"url": "https://example.com/image4.jpg",
					"alt": "Example image 4"
				},
				{
					"type": "text",
					"content": "Page 4 content"
				}
			]
		},
		{
			"id": 5,
			"name": "Page 5",
			"elements": [{
					"type": "button",
					"label": "Exit",
					"action": "exit"
				},
				{
					"type": "image",
					"url": "https://example.com/image5.jpg",
					"alt": "Example image 5"
				},
				{
					"type": "text",
					"content": "Page 5 text"
				}
			]
		}
	]

}"""

}